package com.rozetka.utils;

import java.sql.*;
import java.text.SimpleDateFormat;

public class DataBase {
    private static final String MYSQL_DRIVER="com.mysql.jdbc.Driver";
    private static final String ORACLE_DRIVER="org.postgresql.Driver";
    private static final String MSSQL_DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";

    private static final String DB_LOGIN = PropertyLoader.loadUserProperty("dbUserName");
    private static final String DB_PASS = PropertyLoader.loadUserProperty("dbPassword");
    private static final String DB_LOCATION = PropertyLoader.loadUserProperty("dbLocation");/*   //mysql-kstest2.t1.tenet:3306/sutter_health      */

    private static String dbDriver="";
    private static String dbConnect="";

    public static final String executeSQLQuery(String query, String columnName){
        String result = null;
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSets=null;
        determinDB();
        try {
            Class.forName(dbDriver);//Driver registration
            conn = DriverManager.getConnection(dbConnect+ DB_LOCATION,
                    DB_LOGIN, DB_PASS);//Set connection to the database
            statement = conn.createStatement();//Request preparation
            resultSets = statement.executeQuery(query);
            while (resultSets.next()) {
                if (query.toLowerCase().contains("date")) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");//Loader.loadProperty("dateFormat"));
                    Timestamp date = resultSets.getTimestamp(columnName);
                    result=dateFormat.format(date);
                }else result=resultSets.getString(columnName);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("DB ERROR!");
        } finally {
            try {
                if(resultSets!=null) resultSets.close();
                if (statement!=null) statement.close();
                if (conn!=null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }if (result==null){
            throw new RuntimeException("ERROR! Can't find in DB!");
        } else return result;
    }

    private static void determinDB(){
        switch (PropertyLoader.loadProperty("dbType").toLowerCase()){
            case "mysql" :
                dbDriver=MYSQL_DRIVER;
                dbConnect="jdbc:mysql:";
                break;
            case "oracle" :
                dbDriver=ORACLE_DRIVER;
                dbConnect="jdbc:oracle:";
                break;
            case "mssql" :
                dbDriver=MYSQL_DRIVER;
                dbConnect="jdbc:sqlserver";
                break;
        }
    }
    
//    public static final String[][] executeSQLQueryToArray(String query){
//    	 String result = null;
//         Connection conn = null;
//         Statement statement = null;
//         ResultSet resultSets=null;
//         int i=0;
//         String[][] array;
//         
//         try {
//             Class.forName("com.mysql.jdbc.Driver");//Driver registration
//             conn = DriverManager.getConnection("jdbc:mysql:"+DB_LOCATION,
//                     DB_LOGIN, DB_PASS);//Set connection to the database
//             statement = conn.createStatement();//Request preparation
//             resultSets = statement.executeQuery(query);
//             while(resultSets.next()){
//            	 
//             }
//         }
//    }
}

//Example  DataBase.executeSQLQuery("SELECT project_number from projects WHERE project_number=1", "project_number" );
