/**
 * UserValidationServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mysql.conn;

public class UserValidationServiceLocator extends org.apache.axis.client.Service implements com.mysql.conn.UserValidationService {

    public UserValidationServiceLocator() {
    }


    public UserValidationServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UserValidationServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for UserValidation
    private java.lang.String UserValidation_address = "http://localhost:9091/UserValidationUsingWebservice/services/UserValidation";

    public java.lang.String getUserValidationAddress() {
        return UserValidation_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String UserValidationWSDDServiceName = "UserValidation";

    public java.lang.String getUserValidationWSDDServiceName() {
        return UserValidationWSDDServiceName;
    }

    public void setUserValidationWSDDServiceName(java.lang.String name) {
        UserValidationWSDDServiceName = name;
    }

    public com.mysql.conn.UserValidation getUserValidation() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(UserValidation_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getUserValidation(endpoint);
    }

    public com.mysql.conn.UserValidation getUserValidation(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.mysql.conn.UserValidationSoapBindingStub _stub = new com.mysql.conn.UserValidationSoapBindingStub(portAddress, this);
            _stub.setPortName(getUserValidationWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setUserValidationEndpointAddress(java.lang.String address) {
        UserValidation_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.mysql.conn.UserValidation.class.isAssignableFrom(serviceEndpointInterface)) {
                com.mysql.conn.UserValidationSoapBindingStub _stub = new com.mysql.conn.UserValidationSoapBindingStub(new java.net.URL(UserValidation_address), this);
                _stub.setPortName(getUserValidationWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("UserValidation".equals(inputPortName)) {
            return getUserValidation();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://conn.mysql.com", "UserValidationService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://conn.mysql.com", "UserValidation"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("UserValidation".equals(portName)) {
            setUserValidationEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
