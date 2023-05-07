package core;

public class UserStoryGateway {
    UserStory userStory;
    UserStoryGateway(UserStory userStory){
        this.userStory = userStory;
    }
    public void addObserver(Observer observer){
        this.userStory.addObserver(observer);
    }
    public void removeObserver(Observer observer){
        this.userStory.removeObserver(observer);
    }
}
