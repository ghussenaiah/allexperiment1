/**
 * UserValidationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mysql.conn;

public interface UserValidationService extends javax.xml.rpc.Service {
    public java.lang.String getUserValidationAddress();

    public com.mysql.conn.UserValidation getUserValidation() throws javax.xml.rpc.ServiceException;

    public com.mysql.conn.UserValidation getUserValidation(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
