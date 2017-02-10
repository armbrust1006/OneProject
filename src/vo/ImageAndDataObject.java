package vo;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class ImageAndDataObject implements Serializable {
	private ImageIcon img1, img2;
	private String data1, data2, data3;

	public ImageAndDataObject(ImageIcon img1, ImageIcon img2, String data1, String data2, String data3) {
		super();
		this.img1 = img1;
		this.img2 = img2;
		this.data1 = data1;
		this.data2 = data2;
		this.data3 = data3;
	}

	public ImageIcon getImg1() {
		return img1;
	}

	public void setImg1(ImageIcon img1) {
		this.img1 = img1;
	}

	public ImageIcon getImg2() {
		return img2;
	}

	public void setImg2(ImageIcon img2) {
		this.img2 = img2;
	}

	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public String getData2() {
		return data2;
	}

	public void setData2(String data2) {
		this.data2 = data2;
	}

	public String getData3() {
		return data3;
	}

	public void setData3(String data3) {
		this.data3 = data3;
	}

}
