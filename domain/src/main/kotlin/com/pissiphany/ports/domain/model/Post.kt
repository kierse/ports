package com.pissiphany.ports.domain.model

/**
 * Created by kierse on 2016-08-10.
 */
data class Post(
        val userId: Long? = null,
        val id: Long? = null,
        val title: String? = null,
        val body: String? = null
)

//package com.pissiphany.domain.model;
//
//import com.google.auto.value.AutoValue;
//import com.pissiphany.ports.domain.AutoGson;
//
///**
// * Created by kierse on 2016-07-17.
// */
//@AutoValue
//@AutoGson(autoValueClass = AutoValue_Post.class)
//        public abstract class Post {
//    public abstract Long userId();
//    public abstract Long id();
//    public abstract String title();
//    public abstract String body();
//
//    public static Builder builder() {
//        return new AutoValue_Post.Builder();
//    }
//
//    @AutoValue.Builder
//    public abstract static class Builder {
//        public abstract Builder userId(Long userId);
//        public abstract Builder id(Long id);
//        public abstract Builder title(String title);
//        public abstract Builder body(String body);
//
//        public abstract Post build();
//    }
//}
