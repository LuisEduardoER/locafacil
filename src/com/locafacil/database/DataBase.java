package com.locafacil.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	public static Connection connection;
	public Statement statement;
	public ResultSet resultset;
	private String databaseType;
	private String host;
	private String databaseName;
	private String userName;
	private String password;
	private String connectionString;
	
	public DataBase(){
		
	}
	public DataBase(String databaseType, String host, String databaseName, String userName, String password){
		setDatabaseType(databaseType);
		setHost(host);
		setDatabaseName(databaseName);
		setUserName(userName);
		setPassword(password);
	}
	
	public void open(){
		// exemplo de criação de conexão;
		// Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/BANCO_DE_DADOS?user=root&password=root");
		String str = "jdbc:"+getDatabaseType()+"://"+getHost()+"/"+getDatabaseName()+"?user="+getUserName()+"&password="+getPassword();
		setConnectionString(str);
		try {
			setConnection(DriverManager.getConnection(getConnectionString()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @return the connectionString
	 */
	public String getConnectionString() {
		return connectionString;
	}

	/**
	 * @param connectionString the connectionString to set
	 */
	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	/**
	 * @param connection the connection to set
	 */
	public static void setConnection(Connection connection) {
		DataBase.connection = connection;
	}
	/**
	 * @return the statement
	 */
	public Statement getStatement() {
		return statement;
	}
	/**
	 * @param statement the statement to set
	 */
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	/**
	 * @return the resultset
	 */
	public ResultSet getResultset(String query) {
		try {
			if(DataBase.connection!=null && !DataBase.connection.isClosed()){
				try {
					setStatement(connection.createStatement());
					setResultset(statement.executeQuery(query));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					try {
						statement.close();
						resultset.close();
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
				}
			} else {
				open();
				return getResultset(query);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getResultset();
	}
	public ResultSet getResultset() {
		return resultset;
	}
	
	
	public void executeQuery(String query) {
		if(DataBase.connection!=null){
			try {
				setStatement(connection.createStatement());
				getStatement().executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				try {
					getStatement().close();
					getResultset().close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
		} else {
			open();
			executeQuery(query);
		}
	}
	
	/**
	 * @param resultset the resultset to set
	 */
	public void setResultset(ResultSet resultset) {
		this.resultset = resultset;
	}
	/**
	 * @return the databaseType
	 */
	public String getDatabaseType() {
		return databaseType;
	}
	/**
	 * @param databaseType the databaseType to set
	 */
	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}
	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}
	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}
	/**
	 * @return the databaseName
	 */
	public String getDatabaseName() {
		return databaseName;
	}
	/**
	 * @param databaseName the databaseName to set
	 */
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
