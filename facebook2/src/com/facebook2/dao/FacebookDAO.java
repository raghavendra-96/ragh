package com.facebook2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.facebook2.entity.FacebookEmployee;

public class FacebookDAO implements FacebookDAOInterface {
private FacebookDAO(){}
	public static FacebookDAOInterface createDaoObject() {
		// TODO Auto-generated method stub
		return new FacebookDAO();
	}
	@Override
	public int createProfileDAO(FacebookEmployee fe) {
		// TODO Auto-generated method stub
		int i=0;
		try{
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Zensar123");
		 //  Properties props=new Properties();
		   //props.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
		 //  props.put(Context.PROVIDER_URL,"LOCALHOST:1099");
		 //  props.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
		    InitialContext ctx=new InitialContext();
		    DataSource ds;
		    ds=(DataSource)ctx.lookup("java:/zensar");
		    //datasource is 
			Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into facebook2 values(?,?,?,?)");
			ps.setString(1, fe.getName());
			ps.setString(2, fe.getPass());
			ps.setString(3, fe.getEmail());
			ps.setString(4, fe.getAddress());
			i=ps.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}

}
