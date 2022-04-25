class Solution {
    public String interpret(String command) {
        // 번역 문제 () -> o , (al) -> al
        
        command = command.replace("()","o");
        command = command.replace("(al)","al");
       
        
        return command;
        
    }
}