package Chapter18.Example01;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class Directory {
    public static File[] local(File dir, final String regex){
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }
    public static File[] local(String path, final String regex){ //重载
        return local(new File(path), regex);
    }
    public static class TreeInfo implements Iterable<File>{
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();
        public Iterator<File> iterator(){
            return files.iterator();
        }
        void addAll(TreeInfo other){
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }
        public String toString(){
            return "dirs: "+ dirs + "\n\nfiles: " +files;
        }
    }
    public static TreeInfo walk(String start, String regex){
        return recurseDir(new File(start), regex);
    }
    public static TreeInfo walk(File start, String regex){
        return recurseDir(start, regex);
    }
    public static TreeInfo walk(File start){
        return recurseDir(start, ".*");
    }
    public static TreeInfo walk(String start){
        return recurseDir(new File(start), ".*");
    }
    static TreeInfo recurseDir(File startDir, String regex){
        TreeInfo result =  new TreeInfo();
        for(File item : startDir.listFiles()){
            if(item.isDirectory()){
                result.dirs.add(item);
                result.addAll(recurseDir(item,regex));
            }else {
                if(item.getName().matches(regex))
                    result.files.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        if(args.length == 0)
            System.out.println(walk("."));
        else
            for(String arg :args)
                System.out.println(walk(arg));
    }

}
