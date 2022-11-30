module.exports = {
    // css: {
    //     loaderOptions: {
    //         sass: {
    //             additionalData: `@import "~@/variables.sass"`
    //           },
    //     }
    // },
    devServer: {
        port: 19002,
        proxy: {
            '^/': {
                target: 'http://localhost:19001',
                changeOrigin: true
            }
        },
    },
}