package lec;

public class Rect {
	int width,height;

	public Rect(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		Rect tar = (Rect) obj;
		if(tar.width*tar.height == this.width*this.height) return true;
		return false;
	}
	
	

}
