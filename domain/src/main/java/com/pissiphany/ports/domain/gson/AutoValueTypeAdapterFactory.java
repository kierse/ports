package com.pissiphany.ports.domain.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.pissiphany.ports.domain.annotation.AutoGson;

/**
 * Created by kierse on 2016-08-07.
 */

public class AutoValueTypeAdapterFactory implements TypeAdapterFactory {
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        Class<T> rawType = (Class<T>) type.getRawType();

        // Only deserialize classes decorated with @AutoGson.
        AutoGson annotation = rawType.getAnnotation(AutoGson.class);
        if (annotation == null) {
            return null;
        }

        return (TypeAdapter<T>) gson.getAdapter(annotation.autoValueClass());
    }
}


//class AutoValueTypeAdapterFactory : TypeAdapterFactory {
//        override fun <T : Any?> create(gson: Gson?, type: TypeToken<T>?): TypeAdapter<T>? {
//        val annotation = type?.rawType?.getAnnotation(AutoGson::class.java) ?: return null
//        return gson?.getAdapter(annotation.autoValueClass.java) as TypeAdapter<T>
//    }
//}
