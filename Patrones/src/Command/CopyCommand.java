package Command;

class CopyCommand implements CommandEditor {
	private Documento doc;
	public CopyCommand(Documento doc) { this.doc = doc; }
	public void execute() { doc.copiar(); }
}