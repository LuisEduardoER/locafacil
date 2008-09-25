package com.locafacil.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.locafacil.common.Address;
import com.locafacil.common.Client;

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
	public static DataBase db;
	public DataBase(){
		
	}
	
	public static DataBase getDataBase(){
		if(DataBase.db==null){
			DataBase.db = new DataBase();
			db.setDatabaseName("gregorio_locafacil");
			db.setDatabaseType("mysql");
			db.setHost("danielgregorio.com");
			db.setPassword("loca123");
			db.setUserName("gregorio_locafacil");	
		}
		
		return db;
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

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str = "jdbc:"+getDatabaseType()+"://"+getHost()+"/"+getDatabaseName();
		setConnectionString(str);
		try {
			System.out.println("opening connection with connectionString = "+getConnectionString()+" user name "+ getUserName()+ " password "+getPassword());
			setConnection(DriverManager.getConnection(getConnectionString(),getUserName(),getPassword()));
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
						//statement.close();
						//resultset.close();
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
	
	public Vector<Client> getClients(){
		ResultSet rs = getDataBase().getResultset(" SELECT * FROM `lf_cad_cliente`");
		return clients2Vector(rs);
	}
	
	private Vector<Client> clients2Vector(ResultSet rs){
		Vector<Client> result = new Vector<Client>();

		try {
			while(rs.next()){
				Client cl = new Client();
				cl.setCode(rs.getInt("in_cod_cliente"));
				cl.setName(rs.getString("vc_nome"));
				cl.setDocument(rs.getString("vc_cpf_cnpj"));
				cl.setTelephone(rs.getString("vc_telefone"));
				cl.setEmail(rs.getString("vc_email"));
				Address add = new Address();
				//add.setCity(rs.getString("vc_cidade"));
				add.setLongterm(rs.getString("vc_endereco"));
				//add.setState(rs.getString("vc_estado"));
				//add.setPostal(rs.getString("vc_cep"));
				cl.setAddress(add);
				cl.setBirthday(rs.getDate("dt_data_nascimento"));
				cl.setFinancialStatus(rs.getInt("bl_situacao"));
				result.addElement(cl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
