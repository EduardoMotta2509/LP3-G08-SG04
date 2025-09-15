package Experiencia;

public class SistemaBancario {
	public static void main(String[] args) {
        try {
            
            CuentaBancaria cuenta1 = new CuentaBancaria("001", "Juan", 1000);
            System.out.println("Cuenta creada - Saldo: " + cuenta1.getSaldo());
            
            try { cuenta1.depositar(-100); } 
            catch (IllegalArgumentException e){ 
            	System.out.println("ERROR: " + e.getMessage()); 
            }
            
            try { cuenta1.retirar(2000); } 
            catch (SaldoInsuficienteException e){ 
            	System.out.println("ERROR: " + e.getMessage()); 
            }

            CuentaBancaria cuenta2 = new CuentaBancaria("002", "Ana", 500);

            try { cuenta1.transferir(null, 100); } 
            catch (CuentaNoEncontradaException e){ 
            	System.out.println("ERROR: " + e.getMessage()); 
            }

            try { cuenta1.cerrarCuenta(); } 
            catch (SaldoNoCeroException e){ 
            	System.out.println("ERROR: " + e.getMessage()); 
            }

            CuentaCredito cuentaCredito = new CuentaCredito("003", "Carlos", 1000, 2000);

            cuentaCredito.retirar(2500);
            System.out.println("Retiro con crédito - Saldo: " + cuentaCredito.getSaldo());

            try { cuentaCredito.retirar(1000); } 
            catch (LimiteCreditoExcedidoException e){ 
            	System.out.println("ERROR: " + e.getMessage()); 
            }

            cuenta1.depositar(500);
            cuenta1.transferir(cuenta2, 300);
            System.out.println("Transferencia exitosa - Saldo cuenta1: " + cuenta1.getSaldo());
            System.out.println("Saldo cuenta2: " + cuenta2.getSaldo());

        }catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}