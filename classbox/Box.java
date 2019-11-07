package classbox;

public class Box {
    private double length;
    private double width;
    private double height;

    private void setLength(double length) {
        if (length > 0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
    }

    private void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
    }

    private void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
    }

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public double calculateSurfaceArea() {
        return 2*height*width + 2*height*length + 2*width*length;
    }

    public double calculateLateralSurfaceArea() {
        return 2*height*length + 2*width*height;
    }

    public double calculateVolume() {
        return length*width*height;
    }
}
