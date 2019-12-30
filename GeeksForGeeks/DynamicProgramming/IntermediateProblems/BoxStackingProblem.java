class BoxStackingProblem {
    public int getMaxHeight(Box [] arr, int n) {
        Box [] rotations = new Bos[3 * arr.length];

        for (int i = 0; i < arr.length; i++) {
            Box box = arr[i];
            rotations[3 * i] = new Box(box.h, Math.max(box.w, box.d), Math.min(box.w, box.d));
            rotations[3 * i + 1] = new Box(box.w, Math.max(box.d, box.h), Math.min(box.h, box.d)));
            rotations[3 * i + 2] = new Box(box.d), Math.max(box.w, box.h), Math.min(box.w, box.h));
        }

        for (int i = 0; i < rotations.length; i++) {
            rotations[i].area = rotations[i].w * rotations[i].d;
        }

        Arrays.sort(rotations);

        int [] msh = new int[rotations.length];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < rotations.length; i++) {
            Box curr = rotations[i];
            int val = 0;
            for (int j = 0; j < i; j++) {
                Box prev = rotations[j];
                if (curr.w < prev.w && curr.d < prev.d) {
                    val = Math.max(val, msh[j]);
                }
            }

            msh[i] = val + curr.h;
            res = Math.max(res, msh[i]);
        }

        return res;
    }
}

class Box implements Comparable<Box> {
    int h;
    int w;
    int d;

    int area;

    public Box(int h, int w, int d) {
        this.h = h;
        this.w = w;
        this.d = d;
    }

    @Override
    public int compareTo(Box o) {
        return o.area-this.area;
    }
}
