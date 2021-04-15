/**
 * @author Oscar Estrada 20565
 *
 */
public class Traduccion {
	private String english = "";
	private String spanish = "";
	private String french = "";
	
	public Traduccion() {}

	/**
	 * @return the english
	 */
	public String getEnglish() {
		return english;
	}

	/**
	 * @return the spanish
	 */
	public String getSpanish() {
		return spanish;
	}

	/**
	 * @return the french
	 */
	public String getFrench() {
		return french;
	}

	/**
	 * @param english the english to set
	 */
	public void setEnglish(String english) {
		this.english = english;
	}

	/**
	 * @param spanish the spanish to set
	 */
	public void setSpanish(String spanish) {
		this.spanish = spanish;
	}

	/**
	 * @param french the french to set
	 */
	public void setFrench(String french) {
		this.french = french;
	}

	@Override
	public String toString() {
		return "Traduccion [english=" + english + ", spanish=" + spanish + ", french=" + french + "]";
	}
}
