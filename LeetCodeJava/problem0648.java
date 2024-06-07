package LeetCodeJava;

import java.util.*;

public class problem0648 {
    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dictionary, sentence));
        List<String> dictionary2 = Arrays.asList("a", "b", "c");
        String sentence2 = "aadsfasf absbs bbab cadsfafs";
        System.out.println(replaceWords(dictionary2, sentence2));
        List<String> dictionary3 = Arrays.asList("e","k","c","harqp","h","gsafc","vn","lqp","soy","mr","x","iitgm","sb","oo","spj","gwmly","iu","z","f","ha","vds","v","vpx","fir","t","xo","apifm","tlznm","kkv","nxyud","j","qp","omn","zoxp","mutu","i","nxth","dwuer","sadl","pv","w","mding","mubem","xsmwc","vl","farov","twfmq","ljhmr","q","bbzs","kd","kwc","a","buq","sm","yi","nypa","xwz","si","amqx","iy","eb","qvgt","twy","rf","dc","utt","mxjfu","hm","trz","lzh","lref","qbx","fmemr","gil","go","qggh","uud","trnhf","gels","dfdq","qzkx","qxw");
        String sentence3 = "ikkbp miszkays wqjferqoxjwvbieyk gvcfldkiavww vhokchxz dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dco kddxmckhvqifbuzkhstp wc ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy ifvifheoxqlbosfww mengfdydekwttkhbzenk wjhmmyltmeufqvcpcxg hthcuovils ldipovluo aiprogn nusquzpmnogtjkklfhta klxvvlvyh nxzgnrveghc mpppfhzjkbucv cqcft uwmahhqradjtf iaaasabqqzmbcig zcpvpyypsmodtoiif qjuiqtfhzcpnmtk yzfragcextvx ivnvgkaqs iplazv jurtsyh gzixfeugj rnukjgtjpim hscyhgoru aledyrmzwhsz xbahcwfwm hzd ygelddphxnbh rvjxtlqfnlmwdoezh zawfkko iwhkcddxgpqtdrjrcv bbfj mhs nenrqfkbf spfpazr wrkjiwyf cw dtd cqibzmuuhukwylrnld dtaxhddidfwqs bgnnoxgyynol hg dijhrrpnwjlju muzzrrsypzgwvblf zbugltrnyzbg hktdviastoireyiqf qvufxgcixvhrjqtna ipfzhuvgo daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh qzsaobsghgm ichlpsjlsrwzhbyfhm ksenb bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala qmxixtooxtbrzyorn gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn frotscysdyclrc ckcttaceuuxzcghw pxbd oklwhcppuziixpvihihp";
        System.out.println(replaceWords(dictionary3, sentence3));
    }

    // Slightly better solution
    public static String replaceWords(List<String> dictionary, String sentence) {
        String result = "";
        String[] words = sentence.split(" ");
        Map<String, Boolean> dictMap = new HashMap<>();
        int maxLengthOfRootWord = 0;
        for (String word : dictionary) {
            if (word.length() > maxLengthOfRootWord) {
                maxLengthOfRootWord = word.length();
            }
            dictMap.put(word, true);
        }

        for (String word : words) {
            int index = 0;
            int maxIndex = maxLengthOfRootWord ;
            if (word.length() < maxLengthOfRootWord) {
                maxIndex = word.length();
            }
            boolean isDerivative = false;
            while (index < maxIndex) {
                if (dictMap.containsKey(word.substring(0, index+1))) {
                    result += word.substring(0, index+1) + " ";
                    isDerivative = true;
                    break;
                }
                index++;
            }

            if (!isDerivative) {
                result += word + " ";
            }
        }

        return result.trim();
    }

    // Slow accepted solution
    public static String replaceWords1(List<String> dictionary, String sentence) {
        Map<String, Boolean> dictMap = new HashMap<>();
        for (String word : dictionary) {
            dictMap.put(word, true);
        }
        int leftIndex = 0;
        int rightIndex = 0;
        String result = "";
        while (rightIndex < sentence.length()) {
            if (sentence.charAt(rightIndex) == ' ' || rightIndex == sentence.length()-1) {
                result += sentence.substring(leftIndex, rightIndex+1);
                rightIndex++;
                leftIndex = rightIndex;
                continue;
            }
            if (dictMap.containsKey(sentence.substring(leftIndex, rightIndex+1))) {
                result += sentence.substring(leftIndex, rightIndex+1);
                while (rightIndex < sentence.length() && sentence.charAt(rightIndex) != ' ') {
                    rightIndex++;
                }
                if (rightIndex < sentence.length()) {
                    result += " ";
                }
                leftIndex = rightIndex + 1;
            }
            rightIndex++;
        }
        return result;
    }
}
