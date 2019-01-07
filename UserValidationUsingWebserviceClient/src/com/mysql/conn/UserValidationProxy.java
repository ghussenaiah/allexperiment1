package com.mysql.conn;

public class UserValidationProxy implements com.mysql.conn.UserValidation {
  private String _endpoint = null;
  private com.mysql.conn.UserValidation userValidation = null;
  
  public UserValidationProxy() {
    _initUserValidationProxy();
  }
  
  public UserValidationProxy(String endpoint) {
    _endpoint = endpoint;
    _initUserValidationProxy();
  }
  
  private void _initUserValidationProxy() {
    try {
      userValidation = (new com.mysql.conn.UserValidationServiceLocator()).getUserValidation();
      if (userValidation != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)userValidation)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)userValidation)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (userValidation != null)
      ((javax.xml.rpc.Stub)userValidation)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.mysql.conn.UserValidation getUserValidation() {
    if (userValidation == null)
      _initUserValidationProxy();
    return userValidation;
  }
  
  public java.lang.String loginUser(java.lang.String userName, java.lang.String passWord) throws java.rmi.RemoteException{
    if (userValidation == null)
      _initUserValidationProxy();
    return userValidation.loginUser(userName, passWord);
  }
  
  
}