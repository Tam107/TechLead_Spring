package com.techlead.service.core3;

import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class Core3Service {

    public String convertToPostfix(String exp){
        String result = "";
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < exp.length(); i++){
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)){
                result += c;
            }else if (c == '('){
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '('){
                    result += stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() != '('){
                    return "Invalid Expression";
                }else {
                    stack.pop();
                }
            }else {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){
                    result += stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()){
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }

    private int Prec(char c) {

        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}
