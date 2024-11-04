package com.example.core_module_injector

interface BaseDependencyHolder<D : BaseDependencies> {
    val dependencies: D
}

abstract class DependencyHolder0<D : BaseDependencies>(
) : BaseDependencyHolder<D> {
    abstract val block: (BaseDependencyHolder<D>) -> D

    override val dependencies: D
        get() = block(this)
}

abstract class DependencyHolder1<A1 : BaseAPI, D : BaseDependencies>(
    private val api1: A1,
) : BaseDependencyHolder<D> {
    abstract val block: (BaseDependencyHolder<D>, A1) -> D

    override val dependencies: D
        get() = block(this, api1)
}

abstract class DependencyHolder2<A1 : BaseAPI, A2 : BaseAPI, D : BaseDependencies>(
    private val api1: A1,
    private val api2: A2,
) : BaseDependencyHolder<D> {
    abstract val block: (BaseDependencyHolder<D>, A1, A2) -> D

    override val dependencies: D
        get() = block(this, api1, api2)
}

abstract class DependencyHolder3<A1 : BaseAPI, A2 : BaseAPI, A3 : BaseAPI, D : BaseDependencies>(
    private val api1: A1,
    private val api2: A2,
    private val api3: A3,
) : BaseDependencyHolder<D> {
    abstract val block: (dependencyHolder: BaseDependencyHolder<D>, A1, A2, A3) -> D

    override val dependencies: D
        get() = block(this, api1, api2, api3)
}

abstract class DependencyHolder4<A1 : BaseAPI, A2 : BaseAPI, A3 : BaseAPI,A4 : BaseAPI, D : BaseDependencies>(
    private val api1: A1,
    private val api2: A2,
    private val api3: A3,
    private val api4: A4,
) : BaseDependencyHolder<D> {
    abstract val block: (dependencyHolder: BaseDependencyHolder<D>, A1, A2, A3,A4) -> D

    override val dependencies: D
        get() = block(this, api1, api2, api3, api4)
}
