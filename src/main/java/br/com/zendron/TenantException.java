package br.com.zendron;

/**
 * Created with IntelliJ IDEA. User: Zendron Date: 20/09/13 Time: 18:30 To change this template use File | Settings |
 * File Templates.
 */
public class TenantException extends Exception {

    public TenantException(String message) {
        super(message);
    }

    public String getErrorMessage() {
        return "Tenant não encontrado";
    }

}
