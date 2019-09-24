/**
 * @name Do not use HashSet, prefer LinkedHashSet instead
 * @description Do not use HashSet. In virtually all cases LinkedHashSet is preferable.
 * @kind problem
 * @id java/use-linked-hashset
 * @problem.severity warning
 * @precision high
 */

import java

from Call call, string bad, string better
where
  call.(ConstructorCall).getConstructedType().getQualifiedName().matches("java.util.HashSet<%>") and
  bad = "HashSet" and
  better = "LinkedHashSet"
  or
  call.getCallee().getName() = "toSet" and
  call.getCallee().getDeclaringType().getQualifiedName().matches("java.util.stream.Collectors") and
  bad = "Collectors.toSet" and
  better = "Collectors.toCollection(LinkedHashSet::new)"
select call, "Do not use '" + bad + "', prefer use of '" + better + "' instead."
