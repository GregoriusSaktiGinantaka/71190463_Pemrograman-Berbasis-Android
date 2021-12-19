package com.example.final_71190463;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/example/final_71190463/MainAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/final_71190463/MainHolder;", "data", "Ljava/util/ArrayList;", "Lcom/example/final_71190463/Buku;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/example/final_71190463/MainAdapter$OnAdapterListener;", "(Ljava/util/ArrayList;Lcom/example/final_71190463/MainAdapter$OnAdapterListener;)V", "getListener", "()Lcom/example/final_71190463/MainAdapter$OnAdapterListener;", "setListener", "(Lcom/example/final_71190463/MainAdapter$OnAdapterListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "OnAdapterListener", "app_debug"})
public final class MainAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.final_71190463.MainHolder> {
    private final java.util.ArrayList<com.example.final_71190463.Buku> data = null;
    @org.jetbrains.annotations.NotNull()
    private com.example.final_71190463.MainAdapter.OnAdapterListener listener;
    
    public MainAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.final_71190463.Buku> data, @org.jetbrains.annotations.NotNull()
    com.example.final_71190463.MainAdapter.OnAdapterListener listener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.final_71190463.MainAdapter.OnAdapterListener getListener() {
        return null;
    }
    
    public final void setListener(@org.jetbrains.annotations.NotNull()
    com.example.final_71190463.MainAdapter.OnAdapterListener p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.final_71190463.MainHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.final_71190463.MainHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/final_71190463/MainAdapter$OnAdapterListener;", "", "OnDelete", "", "buku", "Lcom/example/final_71190463/Buku;", "OnEdit", "app_debug"})
    public static abstract interface OnAdapterListener {
        
        public abstract void OnEdit(@org.jetbrains.annotations.NotNull()
        com.example.final_71190463.Buku buku);
        
        public abstract void OnDelete(@org.jetbrains.annotations.NotNull()
        com.example.final_71190463.Buku buku);
    }
}