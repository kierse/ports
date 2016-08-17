package com.pissiphany.ports.domain.model

/**
 * Created by kierse on 2016-08-09.
 */
data class Comment(
        val postId: Long? = null,
        val id: Long? = null,
        val email: String? = null,
        val body: String? = null
)

//@AutoValue
//@AutoGson(autoValueClass = AutoValue_Comment.class)
//        public abstract class Comment {
//    public abstract Long postId();
//    public abstract Long id();
//    public abstract String email();
//    public abstract String body();
//
//    public static Builder builder() {
//        return new AutoValue_Comment.Builder();
//    }
//
//    @AutoValue.Builder
//    public abstract static class Builder {
//        public abstract Builder postId(Long postId);
//        public abstract Builder id(Long id);
//        public abstract Builder email(String email);
//        public abstract Builder body(String body);
//
//        public abstract Comment build();
//    }
//}
