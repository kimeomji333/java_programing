package model.dto;

public class TheaterDTO {
	private int theaterId;
	private String theaterName;
	private String theaterAddr;
	private int seatCnt;
	private int dimension;
	
	public static final int DIMENSION_2D = 0;
    public static final int DIMENSION_3D = 1;
    public static final int DIMENSION_4D = 2;

	public TheaterDTO() {
	}

	public TheaterDTO(int theaterId, String theaterName, String theaterAddr, int seatCnt, int dimension) {
		this.theaterId = theaterId;
		this.theaterName = theaterName;
		this.theaterAddr = theaterAddr;
		this.seatCnt = seatCnt;
		this.dimension = dimension;
	}

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getTheaterAddr() {
		return theaterAddr;
	}

	public void setTheaterAddr(String theaterAddr) {
		this.theaterAddr = theaterAddr;
	}

	public int getSeatCnt() {
		return seatCnt;
	}

	public void setSeatCnt(int seatCnt) {
		this.seatCnt = seatCnt;
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public static int getDimension2d() {
		return DIMENSION_2D;
	}

	public static int getDimension3d() {
		return DIMENSION_3D;
	}

	public static int getDimension4d() {
		return DIMENSION_4D;
	}
	
	
}
