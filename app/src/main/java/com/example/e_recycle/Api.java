package com.example.e_recycle;

public class Api {
//    private  static final  String ROOT_URL = "http://10.23.49.42/API/v1/Api.php?apicall=";
    private  static final  String ROOT_URL = "http://192.168.0.106/API/v1/Api.php?apicall=";

    public static final String URL_CREATE_CLIENTES = ROOT_URL + "createclientes";
    public static final String URL_READ_CLIENTES = ROOT_URL + "getclientes";
    public static final String URL_UPDATE_CLIENTES = ROOT_URL + "updateclientes";
    public static final String URL_DELETE_CLIENTES = ROOT_URL + "deleteclientes&id=";

    //Usuarios
    public static final String URL_CREATE_USUARIOS = ROOT_URL + "createusuario";
    public static final String URL_READ_USUARIOS = ROOT_URL + "getusuario";

    //Login
    public static final String URL_LOGIN = ROOT_URL + "loginUsuario";
    public static final String URL_READ_LOGIN = ROOT_URL + "getUsu";

    //Coletor
    public static final String URL_CREATE_COLETOR = ROOT_URL + "createColetor";
    public static final String URL_READ_COLETOR = ROOT_URL + "getColetor";
}
