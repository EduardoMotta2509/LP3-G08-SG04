package Experiencia;

public class CuentaCredito extends CuentaBancaria{
	private double limiteCredito;

    public CuentaCredito(String numeroCuenta, String titular, double saldoInicial, double limiteCredito) {
        super(numeroCuenta, titular, saldoInicial);
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void retirar(double monto) throws SaldoInsuficienteException, LimiteCreditoExcedidoException {
        if (monto <= 0) throw new IllegalArgumentException("Monto debe ser positivo");
        double disponible = getSaldo() + limiteCredito;
        if (monto > disponible) throw new LimiteCreditoExcedidoException("Límite excedido. Disponible: " + disponible);
        super.depositar(-monto); 
    }
}