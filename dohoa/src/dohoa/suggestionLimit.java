/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dohoa;

/**
 *
 * @author Admin
 */
public class suggestionLimit {
        String s;
    int i, j, k, step, tem;

    public boolean Compare(String s1, String s) {
        tem = (int) Math.round(s.length() * 0.3);
        if (s1.length() < (s.length() - tem) || s1.length() > (s.length() + tem)) {
            return false;
        }
        i = j = step = 0;
        while (i < s.length() && j < s1.length()) {
            if (s.charAt(i) != s1.charAt(j)) {
                step++;
                for (k = 1; k <= tem; k++) {
                    if ((i + k < s.length()) && s.charAt(i + k) == s1.charAt(j)) {
                        i += k;
                        break;
                    } else if ((j + k < s1.length()) && s.charAt(i) == s1.charAt(j + k)) {
                        j += k;
                        break;
                    }
                }
            }
            i++;
            j++;
        }
        step += s.length() - i + s1.length() - j;
        if (step <= tem) {
            return true;
        } else {
            return false;
        }
    }
}
