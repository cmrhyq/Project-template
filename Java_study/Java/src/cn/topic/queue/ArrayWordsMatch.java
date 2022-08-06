package cn.topic.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1 style="color:white">数组中的字符串匹配</h1>
 * <div>
 *     给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。
 *     请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词
 * </div>
 * <div>
 *     <p>输入：words = ["mass","as","hero","superhero"]</p>
 *     <p>输出：["as","hero"]</p>
 *     <p>解释："as" 是 "mass" 的子字符串，"hero" 是 "superhero" 的子字符串。</p>
 *     <p>["hero","as"] 也是有效的答案。</p>
 * </div>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project Java
 * @docRoot cn.topic.queue.ArrayMatch
 * @date 2022/8/6-0:45
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class ArrayWordsMatch {

    /**
     * <h2 style="color:white">暴力枚举</h2>
     * 如果想知道字符串数组中某个字符串word[i]是否是其他字符串的子字符串，只需们枚举word[j]，其中i!=j，
     * 如果word[i]是word[j]的子字符串，则将结果word[i]加入到结果中。
     *
     * @param words word list
     * @return list
     */
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
}
