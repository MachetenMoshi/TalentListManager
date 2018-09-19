package objects;

public class TranslationPair {
	private String fieldName;
	private String readableName;
	
	
	public TranslationPair(String fieldName, String readableName) {
		super();
		this.fieldName = fieldName;
		this.readableName = readableName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getReadableName() {
		return readableName;
	}
	public void setReadableName(String readableName) {
		this.readableName = readableName;
	}
	
	
}
