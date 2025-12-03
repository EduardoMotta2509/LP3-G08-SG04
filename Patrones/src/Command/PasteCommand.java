package Command;

class PasteCommand implements CommandEditor {
	private Documento doc;
	public PasteCommand(Documento doc) { this.doc = doc; }
	public void execute() { doc.pegar(); }
}