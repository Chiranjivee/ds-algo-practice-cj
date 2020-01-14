class GenerateCaptcha {
    String base = "abcdefghijklmnopqrstuvwxyz";
    Random random = new Random();
    public String getCaptcha(int n) {
        StringBuilder captcha = new StringBuilder();
        while (n-- > 0) {
            captcha.append(base.charAt(random.nextInt(25)));
        }
        return captcha.toString();
    }
}
