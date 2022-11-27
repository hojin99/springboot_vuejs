module.exports = {
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