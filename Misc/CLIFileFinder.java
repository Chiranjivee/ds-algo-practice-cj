class File {

    String fileName;
    int sizeInBytes;

    boolean isFolder;
    List<File> subFolders;

    public File(String fileName, int sizeInBytes) {
        this.fileName = fileName;
        this.sizeInBytes = sizeInBytes;
    }
}

class FileFinder {

    public List<String> find(File dir, Condition condition) {
        if (dir == null) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        findUtil(dir, condition, result);
        return result;
    }

    private void findUtil(File dir, Condition condition, List<String> result) {
        if (dir ==  null) {
            return;
        }

       if (dir.isFolder()) {
           for (File subFolder : dir.getSubFolders()) {
               findUtil(subFolder, condition, result);
           }
        } else {
            if (condition.match(dir)) {
                result.add(dir.getFileName());
            }
        }
    }
}

abstract class Condition {
    boolean match(File dir);
}

class ANDCondition {

    List<Condition> conditions;

    public void addCondition(Condition condition) {
        this.conditions.add(condition);
    }

    boolean match(File dir) {
        boolean isMatch = true;
        for (Condition condition : conditions) {
            if (!condition.isMatch()) {
                return false;
            }
        }

        return isMatch;
    }
}

class ORCondition {
    List<Condition> conditions;

    public void addCondition(Condition condition) {
        this.conditions.add(condition);
    }

    boolean match(File dir) {
        boolean isMatch = false;
        for (Condition condition : conditions) {
            if (condition.isMatch()) {
                return true;
            }
        }

        return isMatch;
    }
}

class SizeEqualCondition {
    int requiredFileSize;

    public SizeEqualCondition(String requiredSize) {
        this.requiredFileSize = parse(requiredSize);
    }

    boolean match(File dir) {
        dir.getSizeInBytes ==  requiredFileSize;
    }
}

class HasExtentionCondition {
    String requiredExtention;

    public HasExtentionCondition(String requiredExtention) {
        this.requiredExtention = requiredExtention;
    }

    boolean match(File dir) {
        return dir.getFileName().endsWith(requiredExtention);
    }
}

class CLIRunner {
    FileFinder fileFinder;

    public static void main(String [] args) {
        CLIRunner runner = new CLIRunner();
        Condition condition = new ANDCondition();
        condition.add(new SizeEqualCondition("20KB"));
        condition.add(new HasExtentionCondition(".txt"));

        File dir = getInputDirectory(args);
        List<String> result = runner.getFileFinder().find(dir, condition);
        for (String res : result)  {
            System.out.println(res);
        }
    }

    private static getInputDirectory(String [] args) {
        return null;
    }

    public CLIRunner() {
        this.fileFinder = new FileFinder();
    }
}
