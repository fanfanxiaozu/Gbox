package com.guet.flexbox;


import android.view.View;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.VisibleEvent;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Param;
import com.facebook.litho.annotations.Prop;
import com.guet.flexbox.build.BuildContext;

import org.dom4j.Document;

@LayoutSpec
final class DynamicBoxSpec {

    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c,
                                    @Prop Document layout,
                                    @Prop(optional = true) Object bind) {
        return BuildContext.buildLayout(c, layout, bind);
    }

    @OnEvent(VisibleEvent.class)
    static void onView(ComponentContext c,
                       @Param String json,
                       @Prop(optional = true) EventListener eventListener) {
        if (eventListener != null) {
            eventListener.onEvent(EventType.REPORT_VIEW, json);
        }
    }

    @OnEvent(ClickEvent.class)
    static void onClick(ComponentContext c,
                        @FromEvent View view,
                        @Param String click,
                        @Param String json,
                        @Prop(optional = true) EventListener eventListener) {
        if (eventListener != null) {
            eventListener.onEvent(EventType.CLICK, click);
            if (json != null) {
                eventListener.onEvent(EventType.REPORT_CLICK, json);
            }
        }
    }
}
