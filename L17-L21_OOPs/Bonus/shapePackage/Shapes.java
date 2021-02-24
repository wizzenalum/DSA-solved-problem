package shapePacakage;

protected class Shapes{
	private int lsa;
	private int tsa;
	private int volume;

	//constructor
	Shapes(int lsa, int tsa, int volume){
		this.lsa = lsa;
		this.tsa = tsa;
		this.volume = volume;
	}
	


	void setLsa(int lsa){
		this.lsa = lsa;
	}void setTsa(int tsa){
		this.tsa = tsa;
	}void setVolume(int volume){
		this.volume = volume;
	}
}