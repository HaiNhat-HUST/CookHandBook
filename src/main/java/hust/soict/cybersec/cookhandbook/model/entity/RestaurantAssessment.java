package hust.soict.cybersec.cookhandbook.model.entity;

public class RestaurantAssessment extends Assessment {
    private int restaurantId;

    public RestaurantAssessment() {
        super();
    }

    public RestaurantAssessment(int authorId, int rate, String comment, int restaurantId) {
        super();
        this.restaurantId = restaurantId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
}