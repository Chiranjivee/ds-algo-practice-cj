class ActivitySelection {
    public void selectActivities(Activity[] activities) {
        if (activities == null || activities.length == 0) {
            return;
        }

        System.out.println(activities[0]);
        Activity last = activities[0];
        for (int i = 1; i < activities.length; i++) {
            if (last.endTime < activities[i].startTime) {
                System.out.println(activities[i]);
                last = activities[i];
            }
        }
    }
}


class Activity {
    int startTime;
    int endTime;
}
