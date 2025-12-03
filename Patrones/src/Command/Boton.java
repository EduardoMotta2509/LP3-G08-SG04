package Command;

class Boton {
	private CommandEditor comando;
	public void setComando(CommandEditor comando) { this.comando = comando; }
	public void click() { comando.execute(); }
}