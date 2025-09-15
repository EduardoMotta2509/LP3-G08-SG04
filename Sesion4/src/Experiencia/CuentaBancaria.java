package Experiencia;

public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        if (saldoInicial < 0) throw new IllegalArgumentException("Saldo inicial negativo");
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("Monto debe ser positivo");
        saldo += monto;
    }

    public void retirar(double monto) throws SaldoInsuficienteException, LimiteCreditoExcedidoException {
        if (monto <= 0) throw new IllegalArgumentException("Monto debe ser positivo");
        if (monto > saldo) throw new SaldoInsuficienteException("Saldo insuficiente: " + saldo);
        saldo -= monto;
    }

    public void transferir(CuentaBancaria destino, double monto) throws SaldoInsuficienteException, CuentaNoEncontradaException, LimiteCreditoExcedidoException {
        if (destino == null) throw new CuentaNoEncontradaException("Cuenta destino no existe");
        retirar(monto);
        destino.depositar(monto);
    }

    public void cerrarCuenta() throws SaldoNoCeroException {
        if (saldo != 0) throw new SaldoNoCeroException("Saldo no es cero: " + saldo);
    }

    public double getSaldo() { 
    	return saldo; 
    }
    public String getNumeroCuenta(){ 
    	return numeroCuenta; 
    }
}
