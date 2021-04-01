package id.zelory.compressor.constraint

/**
 * 压缩
 */
class Compression {
    // 保存约束条件。internal 同一模块下可见
    internal val constraints: MutableList<Constraint> = mutableListOf()

    /**
     * 添加约束
     */
    fun constraint(constraint: Constraint) {
        constraints.add(constraint)
    }
}