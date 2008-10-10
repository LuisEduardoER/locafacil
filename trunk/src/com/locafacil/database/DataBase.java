package com.locafacil.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;

import com.locafacil.common.Address;
import com.locafacil.common.Car;
import com.locafacil.common.Client;
import com.locafacil.common.FieldType;
import com.locafacil.common.Rent;

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
//			db.setDatabaseName("gregorio_locafacil");
//			db.setDatabaseType("mysql");
//			db.setHost("danielgregorio.com");
//			db.setPassword("loca123");
//			db.setUserName("gregorio_locafacil");	
			db.setDatabaseName("gregorio_locafacil");
			db.setDatabaseType("mysql");
			db.setHost("localhost");
			db.setPassword("");
			db.setUserName("root");
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
//					try {
//						//statement.close();
//						//resultset.close();
//						//connection.close();
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}			
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
		try {
			if(DataBase.connection!=null && !DataBase.connection.isClosed()){
				try {
					setStatement(connection.createStatement());
					getStatement().execute(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					try {
						getStatement().close();
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
				}
			} else {
				open();
				getDataBase().executeQuery(query);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public String prepareField(int tipo, String value){
		String result = value;
		if(tipo!=FieldType.INT){
			
		} else {
			result = "'"+result+"'";
		}
		return result;
	}
	
	
	
	
	/*==========================================================================*/
	/*							 CLIENTE - ATUALIZAR						    */
	/*==========================================================================*/
	public void updateClient(Client cAntigo, Client cNovo){
		 String sql = "UPDATE `lf_cad_cliente` ";
				sql += "SET `vc_cpf_cnpj` = '"+cNovo.getDocument()+"',";
				sql += "`vc_nome` = '"+cNovo.getName()+"',";
				sql += "`vc_endereco` = '"+cNovo.getAddress().getLongterm()+"',";
				sql += "`in_cod_uf` = '"+cNovo.getAddress().getState()+"',";
				sql += "`in_cod_cidade` = '"+cNovo.getAddress().getCity()+"',";
				sql += "`vc_telefone` = '"+cNovo.getTelephone()+"',";
				sql += "`vc_email` = '"+cNovo.getEmail()+"',";
				sql += "`dt_data_nascimento` = '"+cNovo.getBirthday()+"' ";
				sql += "WHERE `lf_cad_cliente`.`in_cod_cliente` = '"+Integer.toString(cAntigo.getCode())+"' LIMIT 1 ";
				getDataBase().executeQuery(sql);
				System.out.println(sql);

	}
	/*==========================================================================*/
	/*							 CLIENTE - INSERIR 							    */
	/*==========================================================================*/
	public void addClient(Client c){
		String 	sql = "INSERT INTO `lf_cad_cliente` ( `vc_cpf_cnpj` , `vc_nome` , `vc_endereco` , `in_cod_uf` , `in_cod_cidade` , `vc_telefone` , `vc_email` , `dt_data_nascimento` , `bl_situacao` )" ;
				sql += " VALUES ('"+c.getDocument()+"', '"+c.getName()+"', ";
				sql +="'"+c.getAddress().getLongterm()+"', '"+c.getAddress().getState()+"', '"+c.getAddress().getCity()+"', '"+c.getTelephone()+"', ";
				sql +="'"+c.getEmail()+"', '"+c.getBirthday().toString()+"', '"+c.getFinancialStatus()+"');";
		getDataBase().executeQuery(sql);
	}
	/*==========================================================================*/
	/*							 CLIENTE - BUSCAR TODOS						    */
	/*==========================================================================*/
	public Vector<Client> getClients(){
		ResultSet rs = getDataBase().getResultset(" SELECT * FROM `lf_cad_cliente`");
		return clients2Vector(rs);
	}
	/*==========================================================================*/
	/*							 CLIENTE - BUSCAR POR CAMPO					    */
	/*==========================================================================*/
	public Vector<Client> searchClient(int tipoCampo, String campo, String valor){
		
		String sql = " SELECT * FROM `lf_cad_cliente`";
		sql += " WHERE "+campo+" = '"+valor+"'";
		ResultSet rs = getDataBase().getResultset(sql);
		return clients2Vector(rs);
	}
	/*==========================================================================*/
	/*							 CLIENTE - EXCLUIR							    */
	/*==========================================================================*/
	public void deleteClientByCode(int code){
		String sql = "DELETE FROM `lf_cad_cliente` WHERE `lf_cad_cliente`.`in_cod_cliente` = "+code+" LIMIT 1";
		getDataBase().executeQuery(sql);
	}
	
	

	
	/*==========================================================================*/
	/*							 CARROS - ATUALIZAR						        */
	/*==========================================================================*/
	public void updateCars(Car carAntigo, Car carNovo){
		 String sql = "UPDATE `lf_cad_automoveis` ";
				sql += "SET `in_cod_cat_automovel` = '"+carNovo.getCategory().getCategoryCode()+"',";
				sql += "`in_cod_fabrincante` = '"+carNovo.getConstructor()+"',";
				sql += "`in_cod_modelo` = '"+carNovo.getModel()+"',";
				sql += "`in_ano` = '"+carNovo.getYear()+"',";
				sql += "`vc_placa` = '"+carNovo.getPlaca()+"',";
				sql += "`vc_chassi` = '"+carNovo.getChassis()+"'";
				sql += "WHERE `lf_cad_automoveis`.`in_cod_automovel` = '"+Integer.toString(carAntigo.getCode())+"' LIMIT 1 ";
				getDataBase().executeQuery(sql);
				System.out.println(sql);

	}
	/*==========================================================================*/
	/*							 CARROS - INSERIR						    */
	/*==========================================================================*/
	public void addCar(Car ca){
		String sql = "INSERT INTO `lf_cad_automoveis`(`in_cod_cat_automovel`,`in_cod_fabrincante`,`in_cod_modelo`,`in_ano`,`vc_placa`,`vc_chassi`) ";
			   sql += "VALUES('"+ca.getCategory()+"','"+ca.getConstructor()+"','"+ca.getModel()+"','"+ca.getYear()+"','"+ca.getPlaca()+"','"+ca.getChassis()+"')";
		getDataBase().executeQuery(sql);
	}
	/*==========================================================================*/
	/*							 CARROS - BUSCAR							    */
	/*==========================================================================*/
	public Vector<Car> getCars(){
		ResultSet rs = getDataBase().getResultset("SELECT * FROM `lf_cad_automoveis`");
		return cars2Vector(rs);
	}
	/*==========================================================================*/
	/*							 CARROS - BUSCAR POR CAMPO					    */
	/*==========================================================================*/
	public Vector<Car> cars2Vector(ResultSet rs){
		Vector<Car> result = new Vector<Car>();
		try {
			while(rs.next()){
				Car c = new Car();
				c.setPlaca(rs.getString("vc_placa"));
				c.setYear(rs.getInt("in_ano"));
				c.setChassis(rs.getString("vc_chassi"));
				result.addElement(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/*==========================================================================*/
	/*							 CARROS - EXCLUIR							    */
	/*==========================================================================*/
	public void deleteCarByCode(int code){
		String sql = "DELETE FROM `lf_cad_automoveis` WHERE `lf_cad_automoveis`.`in_cod_automovel` = "+code+" LIMIT 1";
		getDataBase().executeQuery(sql);
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
				add.setCity(rs.getString("in_cod_cidade"));
				add.setLongterm(rs.getString("vc_endereco"));
				add.setState(rs.getString("in_cod_uf"));
				//add.setPostal(rs.getString("vc_cep"));
				cl.setAddress(add);
				cl.setBirthday(rs.getString("dt_data_nascimento"));
				cl.setFinancialStatus(rs.getInt("bl_situacao"));
				result.addElement(cl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public Vector<Rent> searchAluguel(String campo, String valor){
		
		String sql = "select al.*, car.vc_nome as nomecarro, cli.vc_nome as nomecliente from  aluguel as al, lf_cad_cliente as cli, lf_cad_automoveis as car where  al.cod_cliente = cli.in_cod_cliente  and finalizado = 0  and car.in_cod_automovel = al.cod_carro";
		sql += " and "+campo+" = '"+valor+"'";
		System.out.println(sql);
		ResultSet rs = getDataBase().getResultset(sql);
		return rs2Rent(rs);
	}
	
	public Vector<Rent> getAlugueis(){
		ResultSet rs = getDataBase().getResultset("select al.*, car.vc_nome as nomecarro, cli.vc_nome as nomecliente from  aluguel as al, lf_cad_cliente as cli, lf_cad_automoveis as car where  al.cod_cliente = cli.in_cod_cliente  and finalizado = 0  and car.in_cod_automovel = al.cod_carro");
		return rs2Rent(rs);
	}
	
	public Vector<Rent> rs2Rent(ResultSet rs){
		Vector<Rent> vetor = new Vector<Rent>();
		try {
			while(rs.next()){
				Rent r = new Rent();
				r.setClient(rs.getString("nomecliente"));
				r.setCar(rs.getString("nomecarro"));
				r.setCode(rs.getInt("codigo"));
				r.setInitialDate(rs.getString("data_saida"));
				r.setEndingDate(rs.getString("data_prevista"));
				r.setFinalizado(rs.getInt("finalizado"));
				vetor.addElement(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vetor;
	}
	
	public Vector<String> rs2Vector(ResultSet rs, String field){
		Vector<String> vt = new Vector<String>();
		try {
			while(rs.next()){
				vt.addElement((String)rs.getString(field));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vt;
	}
	
	public String[] vector2Array(Vector<String> vt){
		String[] array = new String[vt.size()];
		for(int x = 0; x < vt.size(); x++){
			array[x] = (String)vt.elementAt(x);
		}
		return array;
	}
	
	public void addAluguel(Rent r){
		ResultSet rsCli = getDataBase().getResultset("select in_cod_cliente from lf_cad_cliente where vc_nome ='"+r.getClient()+"' LIMIT 1");
		ResultSet rsCar =getDataBase().getResultset("select in_cod_automovel from lf_cad_automoveis where vc_nome ='"+r.getCar()+"' LIMIT 1");
		ResultSet rsVend = getDataBase().getResultset("select in_cod_funcionario from lf_cad_funcionario where vc_nome ='"+r.getFuncionario()+"' LIMIT 1");
		
		try {
			String cod_cli = "";
			String cod_car = "";
			String cod_vend = "";
			while(rsCli.next())cod_cli = rsCli.getString(1);
			while(rsCar.next()) cod_car = rsCar.getString(1);
			while(rsVend.next()) cod_vend = rsVend.getString(1);
			String sql = "INSERT INTO `gregorio_locafacil`.`aluguel` (`codigo` ,`cod_funcionario` ,`cod_cliente` ,`cod_carro` ,`data_saida` ,`data_prevista` ,`obs` ,`finalizado`)VALUES (NULL , '"+cod_vend+"', '"+cod_cli+"', '"+cod_car+"', '"+r.getInitialDate()+"', '"+r.getEndingDate()+"', '"+r.getAdditionalInformation()+"', '0');";
			System.out.println(sql);
			getDataBase().executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		String sql = 
	}
	
	public DefaultComboBoxModel getComboDataBySQL(String sql, String tableField){
		ResultSet rs = getDataBase().getResultset(sql);
		DefaultComboBoxModel model = new DefaultComboBoxModel(vector2Array(rs2Vector(rs, tableField)));
		return model;
	}
	
	public DefaultComboBoxModel getComboData(String tableName, String tableField){
		ResultSet rs = getDataBase().getResultset("select "+tableField+" from "+tableName);
		DefaultComboBoxModel model = new DefaultComboBoxModel(vector2Array(rs2Vector(rs, tableField)));
		return model;
	}
	
}
