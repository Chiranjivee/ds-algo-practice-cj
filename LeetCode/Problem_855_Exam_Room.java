class ExamRoom {

    int N;
    TreeSet<Integer> students;

    public ExamRoom(int N) {
        this.N = N;
        students = new TreeSet();
    }

    public int seat() {

        // Let's determine student, the position of the next
        // student to sit down.
        int student = 0;
        if (students.size() > 0) {

            // Tenatively, dist is the distance to the closest student,
            // which is achieved by sitting in the position 'student'.
            // We start by considering the left-most seat.
            int dist = students.first();
            Integer prev = null;

            for (Integer s: students) {
                if (prev != null) {

                    // For each pair of adjacent students in positions (prev, s),
                    // d is the distance to the closest student;
                    // achieved at position prev + d.
                    int d = (s - prev) / 2;
                    if (d > dist) {
                        dist = d;
                        student = prev + d;
                    }
                }

                prev = s;
            }

            //Considering the right-most seat.
            if (N - 1 - students.last() > dist)
                student = N - 1;
        }

        //Add the student to our sorted TreeSet of positions.
        students.add(student);
        return student;
    }

    public void leave(int p) {
        students.remove(p);
    }
}
