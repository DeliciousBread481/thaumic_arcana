package hu.frontrider.arcana.util;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0002\u0010\bJ\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nJ \u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\rR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"},
   d2 = {"Lhu/frontrider/arcana/util/ListBuilder;", "T", "", "list", "", "(Ljava/util/List;)V", "add", "element", "(Ljava/lang/Object;)Lhu/frontrider/arcana/util/ListBuilder;", "build", "", "print", "printer", "Lkotlin/Function1;", "", "Thaumic Arcana"}
)
public final class ListBuilder<T> {
   private final List<T> list;

   @NotNull
   public final ListBuilder<T> add(T element) {
      this.list.add(element);
      return this;
   }

   @NotNull
   public final List<T> build() {
      return this.list;
   }

   @NotNull
   public final ListBuilder<T> print(@NotNull Function1<? super T, String> printer) {
      Intrinsics.checkParameterIsNotNull(printer, "printer");

      for(Object element$iv : (Iterable)this.list) {
         Object var6 = printer.invoke(element$iv);
         System.out.println(var6);
      }

      return this;
   }

   public ListBuilder(@NotNull List<T> list) {
      Intrinsics.checkParameterIsNotNull(list, "list");
      super();
      this.list = list;
   }
}
