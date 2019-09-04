package com.example.e_recycle;

public class Api {
    private  static final  String ROOT_URL = "http://10.23.49.42/API/v1/Api.php?apicall=";
//    private  static final  String ROOT_URL = "http://192.168.0.26/API/v1/Api.php?apicall=";

    public static final String URL_CREATE_CLIENTES = ROOT_URL + "createclientes";
    public static final String URL_READ_CLIENTES = ROOT_URL + "getclientes";
    public static final String URL_UPDATE_CLIENTES = ROOT_URL + "updateclientes";
    public static final String URL_DELETE_CLIENTES = ROOT_URL + "deleteclientes&id=";

    //Login
    public static final String URL_Login = ROOT_URL + "loginusu";
    public static final String URL_Read_Login = ROOT_URL + "getlogin";
}
