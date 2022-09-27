package com.sample.project.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sample.project.model.Buyer;

//import org.slf4j.LoggerFactory;
@Repository
public class BuyerJdbcDAO implements DAO {
  //private static final Logger log=LoggerFactory.getLogger(BuyerJdbcDAO.class);
    
    private JdbcTemplate jdbcTemplate; 
    RowMapper<Buyer> rowMapper=(rs,rowNum)->{
		Buyer buyer=new Buyer();
		buyer.setName(rs.getString("name"));
		buyer.setContactno(rs.getString("contactno"));
		buyer.setEmail(rs.getString("email"));
		buyer.setAddress(rs.getString("address"));
		buyer.setGender(rs.getString("gender"));
		return buyer;	
	};
    
	public BuyerJdbcDAO(JdbcTemplate jdbcTemplate) {
		
		this.jdbcTemplate = jdbcTemplate;
	}

	/*@Override
	public List list() {
		String sql="SELECT * FROM BUYER";
		return jdbcTemplate.query(sql,rowMapper);
	}*/

	/*@Override
	public Optional<Buyer> get(String name) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}*/

	/*@Override
	public Optional<Buyer> getbyNo(String contactno) {
		String sql="SELECT * from buyer where contactno=?";
		Buyer buyer=null;
		try {
			buyer=jdbcTemplate.queryForObject(sql, new Object[] {contactno}, rowMapper);
		}
		catch(DataAccessException ex)
		{
			log.info("Buyer detail not found: " + contactno);
			System.out.println(ex);
		}
		return Optional.ofNullable(buyer);
	}*/

	@Override
	public Buyer saveBuyer(Buyer buyer) {
		String sql="INSERT INTO BUYER(name,contactno,email,address,gender) VALUES(?,?,?,?,?)";
		 jdbcTemplate.update(sql,buyer.getName(),buyer.getContactno(),buyer.getEmail(),buyer.getAddress(),buyer.getGender());
		 return buyer;
	}

	@Override
	public Buyer getbyNumber(String contactno) {
		 String sql="SELECT * from buyer where contactno=?";
		 Buyer buyer=null;
		 try {
				buyer=jdbcTemplate.queryForObject(sql,rowMapper,new Object[] {contactno});
			}
			catch(Exception e)
			{
				//log.info("Buyer detail not found: " + contactno);
				System.out.println(e);
			}
		 
		 return buyer;
				 //jdbcTemplate.queryForObject(sql, new Object[] {contactno}, rowMapper); 
		 
	}
	@Override
	public Buyer getbyName(String name) {
		 String sql="SELECT * from buyer where name=?";
		 Buyer buyer=null;
		 try {
				buyer=jdbcTemplate.queryForObject(sql,rowMapper,new Object[] {name});
			}
			catch(DataAccessException ex)
			{
				//log.info("Buyer detail not found: " + name);
				System.out.println(ex);
			}
		 return buyer;
				 //jdbcTemplate.queryForObject(sql, new Object[] {contactno}, rowMapper); 
		 
	}

	@Override
	public List<Buyer> allBuyers() {
		String sql="SELECT * FROM BUYER";
		List<Buyer> listOfBuyer=jdbcTemplate.query(sql,rowMapper);
		return listOfBuyer;
	}

	@Override
	public Buyer updateBuyer(Buyer buyer) {
		String sql="Update buyer SET name=?,email=?,address=? where contactno=?";
		jdbcTemplate.update(sql,buyer.getName(),buyer.getEmail(),buyer.getAddress(),buyer.getContactno());
		return buyer;
	}

	@Override
	public String deleteBuyer(String contactno) {
		String sql="Delete from buyer where contactno=?";
	    jdbcTemplate.update(sql, contactno);  
	    //String mob_no="User got deleted with contactno " + contactno;
		return contactno; 
		    }
		
	}

	/*@Override
	public void create(Buyer buyer) {
		String sql="INSERT INTO BUYER(name,contactno,email,address,gender) VALUES(?,?,?,?,?)";
		int insert=jdbcTemplate.update(sql,buyer.getName(),buyer.getContactno(),buyer.getEmail(),buyer.getAddress(),buyer.getGender());
		if(insert == 1)
		{
			log.info("Added new buyer: " + buyer.getName());
		}
		
	}*/
	


