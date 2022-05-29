package com.onequestionperday;

/**
 * 468. 验证IP地址 https://leetcode.cn/problems/validate-ip-address/
 * 给定一个字符串 queryIP。如果是有效的 IPv4 地址，返回 "IPv4" ；如果是有效的 IPv6 地址，返回 "IPv6" ；如果不是上述类型的 IP 地址，返回 "Neither" 。
 * 有效的IPv4地址 是 “x1.x2.x3.x4” 形式的IP地址。 其中 0 <= xi <= 255 且 xi 不能包含 前导零。例如: “192.168.1.1” 、 “192.168.1.0” 为有效IPv4地址，
 * “192.168.01.1” 为无效IPv4地址; “192.168.1.00” 、 “192.168@1.1” 为无效IPv4地址。一个有效的IPv6地址 是一个格式为“x1:x2:x3:x4:x5:x6:x7:x8” 的IP地址，其中:
 * 1 <= xi.length <= 4
 * xi 是一个 十六进制字符串 ，可以包含数字、小写英文字母( 'a' 到 'f' )和大写英文字母( 'A' 到 'F' )。
 * 在 xi 中允许前导零。
 * 例如 "2001:0db8:85a3:0000:0000:8a2e:0370:7334" 和 "2001:db8:85a3:0:0:8A2E:0370:7334" 是有效的 IPv6 地址，而 "2001:0db8:85a3::8A2E:037j:7334" 和 "02001:0db8:85a3:0000:0000:8a2e:0370:7334" 是无效的 IPv6 地址。
 *
 * 示例 1：
 *
 * 输入：queryIP = "172.16.254.1"
 * 输出："IPv4"
 * 解释：有效的 IPv4 地址，返回 "IPv4"
 * 示例 2：
 *
 * 输入：queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * 输出："IPv6"
 * 解释：有效的 IPv6 地址，返回 "IPv6"
 * 示例 3：
 *
 * 输入：queryIP = "256.256.256.256"
 * 输出："Neither"
 * 解释：既不是 IPv4 地址，又不是 IPv6 地址
 *
 *
 * 提示：
 *
 * queryIP 仅由英文字母，数字，字符 '.' 和 ':' 组成。
 * https://www.bilibili.com/video/BV1nK4y147ZF?spm_id_from=333.337.search-card.all.click
 */

class LeetCode468 {
    public String validIPAddress(String queryIP) {
        
        String ip = queryIP.toLowerCase();

        String[] ipv4 = ip.split("\\.", -1);//这里必须要带-1, 因为"1.0.1."这种不符合, 因此必须把最后一个part的空字符串也拿出来
        if(ipv4.length == 4){
            return checkIPv4(ipv4);
        }

        String[] ipv6 = ip.split(":", -1);//如果这里不带参数, 则无法split出来空串
        if(ipv6.length == 8){
            return checkIPv6(ipv6);
        }

        return "Neither";

    }

    public String checkIPv4(String[] ipv4){
        for(String str : ipv4){
            int n = str.length(); //遍历并验证每一个part是否符合条件, 每一个part的长度为n
            //检查长度条件
            if(n == 0 || n > 3){
                return "Neither";
            }
            //检查是否都是数字
            for(int i = 0; i < n; i++){
                if(!Character.isDigit(str.charAt(i))){
                    return "Neither";
                }
            }
            //检查数值范围是否满足
            int num = Integer.parseInt(str);
            if(num < 0 || num > 255){
                return "Neither";
            }
            //检查是否存在前导0
            if(String.valueOf(num).length() < n){ //重新转换为String, 如果存在前导0, 则转换为String的长度会比以前小
                return "Neither";
            }

        }
        return "IPv4";
    }

    public String checkIPv6(String[] ipv6){
        for(String str : ipv6){
            int n = str.length();
            //检查每一个part的长度
            if(n == 0 || n > 4){
                return "Neither";
            }
            //检查每一个part的值
            for(int i = 0; i < n; i++){
                char c = str.charAt(i);
                if((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f')){
                    continue;
                }else{
                    return "Neither";
                }
            }

        }
        return "IPv6";
    }
}








