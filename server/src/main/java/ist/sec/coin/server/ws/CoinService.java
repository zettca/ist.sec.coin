package ist.sec.coin.server.ws;

import ist.sec.coin.server.ws.exception.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.ENCODED)
public interface CoinService {

    @WebMethod
    String echo(
            @WebParam(name = "message") String message)
            throws EchoException;

    @WebMethod
    String register(
            @WebParam(name = "certificate") String certString)
            throws RegisterException;

    @WebMethod
    void sendAmount(
            @WebParam(name = "transaction") TransactionData transaction)
            throws SendAmountException;

    @WebMethod
    AccountStatusData checkAccount(
            @WebParam(name = "fingerprint") String fingerprint)
            throws CheckAccountException;

    @WebMethod
    void receiveAmount(
            @WebParam(name = "transaction") TransactionData transaction)
            throws ReceiveAmountException;

    @WebMethod
    ArrayList<TransactionData> audit(
            @WebParam(name = "address") String address)
            throws AuditException;

    // ===== Used for testing

    @WebMethod
    void clean();
}
