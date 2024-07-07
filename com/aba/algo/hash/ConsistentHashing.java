package com.aba.algo.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * consistent hash
 *
 * @program learn-algo
 * @author: abracadabra
 * @create: 2024/07/07 11:42
 */
public class ConsistentHashing {

    private SortedMap<Long, String> circle = new TreeMap<>();

    private final int numberOfReplicas ;

    private final HashFunction hashFunction;

    public ConsistentHashing(int numberOfReplicas, HashFunction hashFunction){
        this.numberOfReplicas = numberOfReplicas;
        this.hashFunction = hashFunction;
    }

    public void addNode(String node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.put(hashFunction.hash(node + i), node);
        }
    }

    public void removeNode(String node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.remove(hashFunction.hash(node + i));
        }
    }

    public String  getNode(String key) {
        if (circle.isEmpty()) {
            return null;
        }
        long hash = hashFunction.hash(key);
        if (!circle.containsKey(hash)) {
            SortedMap<Long, String> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return  circle.get(hash);
    }

    public static void main(String[] args) {
       HashFunction md5HashFunction = new MD5HashFunction();
       ConsistentHashing consistentHashing = new ConsistentHashing(3, md5HashFunction);
       consistentHashing.addNode("192.168.0.1");
       consistentHashing.addNode("192.168.0.2");
       consistentHashing.addNode("192.168.0.3");

       String[] keys = {"key1", "key2", "key3", "key4", "key5", "key6", "key7", "key8", "key9"};
       for (String key : keys) {
           System.out.println("Node for key " + key + " is " + consistentHashing.getNode(key));
       }

    }





    interface HashFunction{
        long hash(String key);
    };

    static class MD5HashFunction implements HashFunction{
        @Override
        public long hash(String key) {
            MessageDigest md = null;
            try {
                md = MessageDigest.getInstance("MD5");
                byte[] bytes = md.digest(key.getBytes(StandardCharsets.UTF_8));
                return ((long) (bytes[0] & 0xFF) << 24) |
                        ((long) (bytes[1] & 0xFF) << 16) |
                        ((long) (bytes[2] & 0xFF) << 8) |
                        ((long) (bytes[3] & 0xFF));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("MD5 not supported");
            }
        }
    }


}
